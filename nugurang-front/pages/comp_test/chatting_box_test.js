import React from 'react';

import ChattingBox from '../../components/ChattingBox';

export default function CompTest() {

const chats = [
  {
    id: 1,
    name: "User 1",
    content: "Chat message 1",
    isMyChat: false,
    image: "/static/images/sample_1.jpg",
  },
  {
    id: 2,
    name: "User 2",
    content: "Chat message 2",
    isMyChat: true,
    image: "/static/images/sample_2.jpg",
  },
  {
    id: 3,
    name: "User 3",
    content: "Chat message 3",
    isMyChat: false,
    image: "/static/images/sample_3.jpg",
  },
  {
    id: 4,
    name: "User 4",
    content: "Chat message 4",
    isMyChat: true,
    image: "/static/images/sample_4.jpg",
  },
  {
    id: 5,
    name: "User 5",
    content: "Chat message 5",
    isMyChat: false,
    image: "/static/images/sample_5.jpg",
  },
  {
    id: 6,
    name: "User 6",
    content: "Chat message 6",
    isMyChat: true,
    image: "/static/images/sample_6.jpg",
  },
  {
    id: 7,
    name: "User 7",
    content: "Chat message 7",
    isMyChat: false,
    image: "/static/images/sample_7.jpg",
  },
  {
    id: 8,
    name: "User 8",
    content: "Chat message 8",
    isMyChat: true,
    image: "/static/images/sample_8.jpg",
  },
  {
    id: 9,
    name: "User 9",
    content: "Quite a long chat message. 1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890",
    isMyChat: false,
    image: "/static/images/sample_9.jpg",
  },
];

  return (
	<div>
	  <ChattingBox chats={chats} />
	</div>
  );
}
