import React from 'react';
import KsKitGrid from "../../components/KsKitGrid";
import dataMock from "../../dataMock";

const SharePage = () =>
  <>
    <KsKitGrid data={dataMock.content} />
  </>;

export default SharePage;