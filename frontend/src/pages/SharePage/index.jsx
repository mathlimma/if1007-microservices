import React, { useState } from 'react';
import KsKitGrid from "../../components/KsKitGrid";
import KsPaginator from '../../components/KsPaginator';
import KsConfirmModal from "../../components/KsConfirmModal";
import PropTypes from "prop-types";

const SharePage = ({ kits }) => {
  const [displayConfirmModal, setDisplayConfirmModal] = useState(false);

  const onCardClick = () => {
    setDisplayConfirmModal(true);
  };

  const onCardClickConfirm = () => { };

  const onCardClickClose = () => {
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