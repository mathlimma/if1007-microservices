import React from 'react';
import KitGridItem from "./components/KsKitGridItem";
import PropTypes from 'prop-types';

const KsKitGrid = ({ data, hasAnalysis, itemOnClick }) => {
  return (
    <div className="kit-grid my-5">
      <div className="row">
        {data?.map((item) =>
          <KitGridItem
            hasAnalysis={hasAnalysis}
            data={item}
            onClick={() => itemOnClick(item.id)}
            key={item.id}
          />)}
      </div>
    </div>
  );
};

KsKitGrid.propTypes = {
  data: PropTypes.array,
  hasAnalysis: PropTypes.bool,
  itemOnClick: PropTypes.func,
};

KsKitGrid.defaultProps = {
  data: [],
  hasAnalysis: false,
  itemOnClick: null,
};

export default KsKitGrid;
