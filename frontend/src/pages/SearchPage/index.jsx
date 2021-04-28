import React, { useState, useEffect } from 'react';
import KsKitGrid from "../../components/KsKitGrid";
import KsConfirmModal from "../../components/KsConfirmModal";
import { InputGroup, Input } from 'reactstrap';
import axios from '../../services/axios';

const SearchPage = () => {
  const [displayConfirmModal, setDisplayConfirmModal] = useState(false);
  const [query, setQuery] = useState("");
  const [kits, setKits] = useState([]);

  useEffect(() => {
    const timeOutId = setTimeout(() =>
      axios.get(`ks-analysis/api/v1/search?word=${query}`)
        .then((res) => setKits(res.data))
        .catch((err) => console.log(err))
      , 500);
    return () => clearTimeout(timeOutId);
  }, [query]);

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
        <Input placeholder="Procure kits compartilhados" onChange={(event) => setQuery(event.target.value)} />
      </InputGroup>
      <KsKitGrid
        data={kits}
        hasAnalysis
        itemOnClick={onCardClick}
      />
    </div >
  );
};

export default SearchPage;