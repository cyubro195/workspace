import { motion, AnimatePresence } from 'framer-motion';



const ModalAni = ({}) => {

  return createPortal(

    <AnimatePresence>

      {isOpen && (

        <motion.aside

          initial={{ opacity: 0 }}

          animate={{ opacity: 1 }}

          exit={{ opacity: 0 }}

          transition={{ duration: 0.5, ease: "easeInOut" }}

        >

         ...

        </motion.aside>

      )}

    </AnimatePresence>,

    document.body,

  );

};

export default ModalAni;