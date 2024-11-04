// src/PaymentButton.js
import React from 'react';
import { tossPayments } from '@tosspayments/sdk';

const PaymentButton = () => {
  const handlePayment = async () => {
    const { tossPayments } = window;

    tossPayments.requestPayment('카드', {
      orderId: 'your_order_id', // 주문 ID
      amount: 1000, // 결제 금액 (단위: 원)
      orderName: '상품 이름', // 주문명
      customerName: '고객 이름', // 고객 이름
      successUrl: 'http://localhost:3000/success', // 성공 시 이동할 URL
      failUrl: 'http://localhost:3000/fail', // 실패 시 이동할 URL
    }).then((response) => {
      console.log('결제 성공:', response);
    }).catch((error) => {
      console.error('결제 실패:', error);
    });
  };

  return (
    <button onClick={handlePayment}>결제하기</button>
  );
};

export default PaymentButton;
