import React from 'react';
import KsKitGrid from "../../components/KsKitGrid";
import dataMock from "../../dataMock";
import KsPaginator from '../../components/KsPaginator';

const SharePage = () => (
  <div className="container">
    <KsKitGrid data={dataMock.content} />
    <KsPaginator pagesNumber={1} currentPage={1} />
  </div>
);

export default SharePage;