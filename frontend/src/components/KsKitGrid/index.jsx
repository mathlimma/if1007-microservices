import React from 'react';
import KitGridItem from "./components/KitGridItem";
import PropTypes from 'prop-types';

const KsKitGrid = ({ data, hasAnalysis }) => {
  return (
    <div className="kit-grid my-5">
      <div className="row">
        {data?.map((item) =>
          <KitGridItem hasAnalysis={hasAnalysis} data={item} />)}
      </div>
    </div>
  );
};

KsKitGrid.propTypes = {
  hasAnalysis: PropTypes.bool,
};

KsKitGrid.defaultProps = {
  hasAnalysis: false,
};

export default KsKitGrid;
