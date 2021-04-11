import React from "react";
import {
  Card, CardFooter, CardBody, CardTitle, CardText,
} from 'reactstrap';

const KitGridItem = ({ data, hasAnalysis }) => {
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
    <div class="container">
      <div class="row">
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
              <CardText>
                <p>Análise 1 Mussum Ipsum</p>
                <p>Análise 2 Mussum Ipsum, cacilds vidis </p>
                <p>Análise 3 Mussum Ipsum, cacilds vidis litro abertis.</p>
              </CardText>
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
    <div className={`mb-4 col-12 ${hasAnalysis ? "col-md-6" : "col-md-3"}`}>
      <Card>
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

export default KitGridItem;