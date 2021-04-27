/* eslint-disable jsx-a11y/anchor-has-content */
/* eslint-disable jsx-a11y/anchor-is-valid */
import React, { useState } from "react";
import {
  Card, CardFooter, CardBody, CardTitle,
} from 'reactstrap';
import PropTypes from "prop-types";

const KsKitGridItem = ({ data, hasAnalysis, onClick }) => {
  const [engajamento] = useState((Math.random() * 100).toFixed(1).toString());
  const [discutibilidade] = useState((Math.random() * 5).toFixed(1).toString());
  const [consenso] = useState((Math.random() * 50).toFixed(1).toString());

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
                <p>Engajamento:{" "}
                  <span className="font-weight-bold">{engajamento}%</span>
                </p>
                <p>Discutibilidade:{" "}
                  <span className="font-weight-bold">{discutibilidade}</span>
                </p>
                <p>Consenso:{" "}
                  <span className="font-weight-bold">{consenso}</span>
                </p>
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
      {hasAnalysis && (
        <>
          <div className="col">
            <div className="text-center">
              <p>{data.description}</p>
            </div>
          </div>
        </>
      )}
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