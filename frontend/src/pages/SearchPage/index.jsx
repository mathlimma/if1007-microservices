import React, { useState } from 'react';
import KsKitGrid from "../../components/KsKitGrid";
import KsConfirmModal from "../../components/KsConfirmModal";
import { InputGroup, Input } from 'reactstrap';

const SearchPage = () => {
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
        title="Você tem certeza que quer adicionar esse kit?"
        closeCallback={onCardClickClose}
        confirmCallback={onCardClickConfirm} />
      <InputGroup className="mt-5">
        <Input placeholder="Procure kits compartilhados" />
      </InputGroup>
      <KsKitGrid
        data={[]}
        hasAnalysis
        itemOnClick={onCardClick}
      />
    </div >
  );
};

export default SearchPage;