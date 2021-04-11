import React from 'react';
import KitGridItem from "./components/KitGridItem";

const KsKitGrid = ({ data, hasAnalysis }) => {
  return (
    <div className="kit-grid container my-5">
      <div className="row">
        {data?.map((item) =>
          <KitGridItem hasAnalysis={hasAnalysis} data={item} />)}
      </div>
    </div>
  );
};

export default KsKitGrid;
