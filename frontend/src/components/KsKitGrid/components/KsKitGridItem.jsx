/* eslint-disable jsx-a11y/anchor-has-content */
/* eslint-disable jsx-a11y/anchor-is-valid */
import React from "react";
import {
  Card, CardFooter, CardBody, CardTitle,
} from 'reactstrap';
import PropTypes from "prop-types";

const KsKitGridItem = ({ data, hasAnalysis, onClick }) => {
  const handleFooterClasses = () => {
    switch (data.type) {
      case "SYSTEM":
        return "bg-system";
      case "MODEL":
        return "bg-model";
      case "INDICATOR":
        return "bg-indicator";
      case "LEARNING":
        return "bg-learning";
      default:
        return "bg-method";
    }
  };

  const renderCardContent = () => (
    <div className="container">
      <div className="row">
        {hasAnalysis ? (
          <>
            <div className="col d-flex align-items-center justify-content-center">
              <CardTitle
                tag="h5"
                className="text-center">
                {data.title}
              </CardTitle>
            </div>
            <div className="col">
              <div>
                <p>Análise 1 Mussum Ipsum</p>
                <p>Análise 2 Mussum Ipsum, cacilds vidis </p>
                <p>Análise 3 Mussum Ipsum, cacilds vidis litro abertis.</p>
              </div>
            </div>
          </>
        ) : (
          <div className="col">
            <CardTitle
              tag="h5"
              className="text-center">
              {data.title}
            </CardTitle>
          </div>
        )}
      </div>
    </div >
  );

  return (
    <div
      className={`mb-4 col-12 ${hasAnalysis ? "col-md-6" : "col-md-3"}${onClick ? ' cursor-pointer' : ''}`}
      onClick={onClick}>
      <Card className="h-100">
        <CardBody>
          {renderCardContent()}
        </CardBody>
        <CardFooter className={`text-center text-white text-capitalize ${handleFooterClasses()}`}>
          {data.type.toLowerCase()}
        </CardFooter>
      </Card>
    </div>
  );
};

KsKitGridItem.propTypes = {
  data: PropTypes.object,
  hasAnalysis: PropTypes.bool,
  onClick: PropTypes.func,
};

KsKitGridItem.defaultProps = {
  data: {},
  hasAnalysis: false,
  onClick: null,
};

export default KsKitGridItem;