import PropTypes from "prop-types";
import {
  Button, Modal, ModalHeader, ModalBody, ModalFooter,
} from 'reactstrap';

const KsConfirmModal = ({ isOpen, confirmCallback, closeCallback, title, text, canCancel }) => {
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
        {canCancel && <Button onClick={closeCallback}>Cancelar</Button>}
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
  canCancel: PropTypes.bool,
};

KsConfirmModal.defaultTypes = {
  title: "",
  text: "",
  canCancel: true,
};

export default KsConfirmModal;