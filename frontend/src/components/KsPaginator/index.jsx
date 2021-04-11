import React from 'react';
import PropTypes from 'prop-types';
import { Pagination, PaginationItem, PaginationLink } from 'reactstrap';

const KsPaginator = ({ pagesNumber, currentPage }) => {
  const renderPageNumbers = () => Array.from(Array(pagesNumber).keys())
    .map((pageNumber) => (
      <PaginationItem active={currentPage === pageNumber + 1} key={pageNumber}>
        <PaginationLink href="#">
          {pageNumber + 1}
        </PaginationLink>
      </PaginationItem>
    ));

  return (
    <div className="d-flex justify-content-center">
      <Pagination>
        <PaginationItem disabled={currentPage === 1}>
          <PaginationLink first href="#" />
        </PaginationItem>
        <PaginationItem disabled={currentPage === 1}>
          <PaginationLink previous href="#" />
        </PaginationItem>
        {renderPageNumbers()}
        <PaginationItem disabled={currentPage === pagesNumber}>
          <PaginationLink next href="#" />
        </PaginationItem>
        <PaginationItem disabled={currentPage === pagesNumber} >
          <PaginationLink last href="#" />
        </PaginationItem>
      </Pagination>
    </div >
  );
};

KsPaginator.propTypes = {
  pagesNumber: PropTypes.number.isRequired,
  currentPage: PropTypes.number.isRequired,
};

export default KsPaginator;