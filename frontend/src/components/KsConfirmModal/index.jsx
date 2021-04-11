import PropTypes from "prop-types";
import {
  Button, Modal, ModalHeader, ModalBody, ModalFooter,
} from 'reactstrap';

const KsConfirmModal = ({ isOpen, confirmCallback, closeCallback, title, text }) => {
  const confirm = () => {
    confirmCallback();
    closeCallback();
  };

  return (
    <Modal isOpen={isOpen}>
      <ModalHeader>{title}</ModalHeader>
      <ModalBody>
        <p>{text}</p>
      </ModalBody>
      <ModalFooter>
        <Button color="primary" onClick={confirm}>Confirmar</Button>
        <Button onClick={closeCallback}>Cancelar</Button>
      </ModalFooter>
    </Modal>
  );
};


KsConfirmModal.propTypes = {
  isOpen: PropTypes.bool.isRequired,
  confirmCallback: PropTypes.func.isRequired,
  closeCallback: PropTypes.func.isRequired,
  title: PropTypes.string,
  text: PropTypes.string,
};

KsConfirmModal.defaultTypes = {
  title: "",
  text: "",
};

export default KsConfirmModal;