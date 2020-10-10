import Link from 'next/link';
import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import BottomNavigation from '@material-ui/core/BottomNavigation';
import BottomNavigationAction from '@material-ui/core/BottomNavigationAction';
import HomeIcon from '@material-ui/icons/Home';
import ForumIcon from '@material-ui/icons/Forum';
import ChatIcon from '@material-ui/icons/ChatBubble';
import NotificationsIcon from '@material-ui/icons/Notifications';
import GroupIcon from '@material-ui/icons/Group';
import PersonIcon from '@material-ui/icons/Person';
import MoreHorizIcon from '@material-ui/icons/MoreHoriz';
import AppBar from '@material-ui/core/AppBar';
import useStyles from '../components/UseStyles';


const bottomNavBarButtons = [
  {
    label: "Home",
    path: "/home",
    icon: <HomeIcon />
  },
  {
    label: "Forum",
    path: "/forum",
    icon: <ForumIcon />
  },
  {
    label: "Team",
    path: "/team",
    icon: <GroupIcon />
  },
  {
    label: "Person",
    path: "/signin",
    icon: <PersonIcon />
  },
  {
    label: "More",
    path: "/more",
    icon: <MoreHorizIcon />
  }
];

export default function BottomNavBar() {
  const classes = useStyles();
  const [value, setValue] = React.useState('recents');

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <AppBar className={classes.app_bar}>
      <BottomNavigation value={value} onChange={handleChange} className={classes.root}>
        {bottomNavBarButtons.map(button => (
          <Link href={button.path}>
            <BottomNavigationAction
              icon={button.icon}
              label={button.label}
              value={button.path}
            />
          </Link>

        ))}
      </BottomNavigation>
    </AppBar>
  );
}
