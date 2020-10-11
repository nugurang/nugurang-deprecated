import React from 'react';

import ScrollableTabs from '../../components/ScrollableTabs';

export default function CompTest() {

const list = [
  {
    id: 1,
    title: "Tab 1",
  },
  {
    id: 2,
    title: "Tab 2",
  },
  {
    id: 3,
    title: "Tab 3",
  }
];

  return (
	<div>
	  <ScrollableTabs list={list} />
	</div>
  );
}
