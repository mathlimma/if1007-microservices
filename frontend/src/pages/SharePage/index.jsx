import React, { useState } from 'react';
import KsKitGrid from "../../components/KsKitGrid";
import KsPaginator from '../../components/KsPaginator';
import KsConfirmModal from "../../components/KsConfirmModal";
import PropTypes from "prop-types";
import axios from '../../services/axios';

const SharePage = ({ kits }) => {
  const [displayConfirmModal, setDisplayConfirmModal] = useState(false);
  const [clickedId, setClickedId] = useState(null);

  const onCardClick = (id) => {
    setClickedId(id);
    setDisplayConfirmModal(true);
  };

  const onCardClickConfirm = () => {
    axios.post(`/ks-core/api/v1/kits/${clickedId}`)
      .then((res) => console.log(res));
  };

  const onCardClickClose = () => {
    setClickedId(null);
    setDisplayConfirmModal(false);
  };

  return (
    <div className="container">
      <KsConfirmModal
        isOpen={displayConfirmModal}
        title="Você tem certeza que quer compartilhar esse kit?"
        text="Ele ficará disponível para todos os usuários da plataforma."
        closeCallback={onCardClickClose}
        confirmCallback={onCardClickConfirm} />
      <KsKitGrid data={kits} itemOnClick={onCardClick} />
      <KsPaginator pagesNumber={1} currentPage={1} />
    </div>
  );
};

SharePage.propTypes = {
  kits: PropTypes.array.isRequired,
};

export default SharePage;