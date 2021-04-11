import React from 'react';
import KsKitGrid from "../../components/KsKitGrid";
import dataMock from "../../dataMock";
import { InputGroup, Input } from 'reactstrap';

const SearchPage = () => (
  <div className="container">
    <InputGroup className="mt-5">
      <Input placeholder="Procure kits compartilhados" />
    </InputGroup>
    <KsKitGrid data={dataMock.content} hasAnalysis />
  </div >
);

export default SearchPage;