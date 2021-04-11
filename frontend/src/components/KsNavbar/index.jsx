import React from 'react';
import {
  Navbar,
  NavItem,
  NavLink,
  Nav,
} from 'reactstrap';
import { NavLink as RRNavLink } from 'react-router-dom';



const KsNavbar = () =>
  <>
    <Navbar color="primary" light expand="md">
      <Nav navbar>
        <NavItem>
          <NavLink
            tag={RRNavLink}
            exact to="/share"
            activeClassName="active text-white font-weight-bold"
            className="text-light">
            Compartilhar
            </NavLink>
        </NavItem>
        <NavItem>
          <NavLink
            tag={RRNavLink}
            exact to="/search"
            activeClassName="active text-white font-weight-bold"
            className="text-light">
            Pesquisar
          </NavLink>
        </NavItem>
      </Nav>
    </Navbar>
  </>
  ;
export default KsNavbar;