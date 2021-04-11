import React from "react";
import {
  Card, CardFooter, CardBody, CardTitle,
} from 'reactstrap';
import { capitalize } from '../../../utils/string';

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

  return (
    <div className={`mb-4 col-12 ${hasAnalysis ? "col-md-6" : "col-md-3"}`}>
      <Card>
        <CardBody>
          <CardTitle
            tag="h5"
            className="text-center">
            {data.title}
          </CardTitle>
        </CardBody>
        <CardFooter className={`text-center text-white ${handleFooterClasses()} `}>
          {capitalize(data.type.toLowerCase())}
        </CardFooter>
      </Card>
    </div>
  );
};

export default KitGridItem;