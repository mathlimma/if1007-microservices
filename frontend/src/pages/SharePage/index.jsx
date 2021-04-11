import React from 'react';
import KsKitGrid from "../../components/KsKitGrid";
import dataMock from "../../dataMock";

const SharePage = () => (
  <div className="container">
    <KsKitGrid data={dataMock.content} />
  </div>
);

export default SharePage;