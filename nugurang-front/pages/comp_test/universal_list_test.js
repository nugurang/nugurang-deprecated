import React from 'react';

import UniversalList from '../../components/UniversalList';

export default function CompTest() {

const list = [
  {
    id: 1,
    primary: "Primary text 1",
    secondary: "Secondary text 1",
    icon: "/static/images/sample_1.jpg",
  },
  {
    id: 2,
    primary: "Primary text 2 without icon",
    secondary: "Secondary text 2",
  },
  {
    id: 3,
    primary: "Primary text 3, no secondary text",
    icon: "/static/images/sample_3.jpg",
    secondary: null,
  },
  {
    id: 4,
    primary: "Primary text 4",
    secondary: "Quite a long secondary text. 1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890",
    icon: "/static/images/sample_4.jpg",
  }
];

  return (
	<div>
	  <UniversalList list={list} />
	</div>
  );
}
