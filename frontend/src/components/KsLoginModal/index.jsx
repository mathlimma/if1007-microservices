import { useState } from 'react';
import PropTypes from "prop-types";
import {
  Button, Modal, ModalHeader, ModalBody, ModalFooter,
  Form, FormGroup, Label, Input,
} from 'reactstrap';
import axios from '../../services/axios';

const KsLoginModal = ({ isOpen, loginCallback }) => {
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();

  const onClickLogin = () => axios.post(`/ks-auth/api/v1/`, {
    email,
    password
  }).then(res => loginCallback(res.data.access_token));

  return (
    <Modal isOpen={isOpen}>
      <ModalHeader>Login</ModalHeader>
      <ModalBody>
        <Form>
          <FormGroup className="mb-3">
            <Label for="email">Email</Label>
            <Input
              type="email"
              name="email"
              id="email"
              placeholder="Seu email"
              onChange={e => setEmail(e.target.value)} />
          </FormGroup>
          <FormGroup>
            <Label for="password">Senha</Label>
            <Input
              type="password"
              name="password"
              id="password"
              placeholder="Sua senha"
              onChange={e => setPassword(e.target.value)} />
          </FormGroup>
        </Form>
      </ModalBody>
      <ModalFooter>
        <Button color="primary" onClick={onClickLogin}>Login</Button>
      </ModalFooter>
    </Modal>
  );
};

KsLoginModal.propTypes = {
  isOpen: PropTypes.bool.isRequired,
  loginCallback: PropTypes.func.isRequired,
};

export default KsLoginModal;