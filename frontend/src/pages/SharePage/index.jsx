import React, { useState } from 'react';
import KsKitGrid from "../../components/KsKitGrid";
import dataMock from "../../dataMock";
import KsPaginator from '../../components/KsPaginator';
import KsConfirmModal from "../../components/KsConfirmModal";

const SharePage = () => {
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
      <KsKitGrid data={dataMock.content} itemOnClick={onCardClick} />
      <KsPaginator pagesNumber={1} currentPage={1} />
    </div>
  );
};

export default SharePage;