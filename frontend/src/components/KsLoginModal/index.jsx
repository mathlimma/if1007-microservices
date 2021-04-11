import PropTypes from "prop-types";
import {
  Button, Modal, ModalHeader, ModalBody, ModalFooter,
  Form, FormGroup, Label, Input,
} from 'reactstrap';

const KsLoginModal = ({ isOpen, loginCallback }) => (
  <Modal isOpen={isOpen}>
    <ModalHeader>Login</ModalHeader>
    <ModalBody>
      <Form>
        <FormGroup className="mb-3">
          <Label for="email">Email</Label>
          <Input type="email" name="email" id="email" placeholder="Seu email" />
        </FormGroup>
        <FormGroup>
          <Label for="password">Senha</Label>
          <Input type="password" name="password" id="password" placeholder="Sua senha" />
        </FormGroup>
      </Form>
    </ModalBody>
    <ModalFooter>
      <Button color="primary" onClick={loginCallback}>Login</Button>{' '}
    </ModalFooter>
  </Modal>
);


KsLoginModal.propTypes = {
  isOpen: PropTypes.bool.isRequired,
  loginCallback: PropTypes.func.isRequired,
};

export default KsLoginModal;