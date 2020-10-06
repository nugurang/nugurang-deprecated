import React from 'react';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import AppBar from '@material-ui/core/AppBar';


const useStyles = makeStyles((theme) => ({
  paper: {
    marginTop: theme.spacing(8),
    marginBottom: theme.spacing(12),
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main,
  },
  form: {
    width: '100%', // Fix IE 11 issue.
    marginTop: theme.spacing(1),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
}));

export default function SignIn() {
  const classes = useStyles();
  return (

	  <Container component="main" maxWidth="xs">
	    <CssBaseline />
	    <div className={classes.paper}>
	      <Avatar className={classes.avatar}>
	        <LockOutlinedIcon />
	      </Avatar>
	      <Typography component="h1" variant="h5">
	        Sign In
	      </Typography>
	      <Button
	        type="submit"
	        fullWidth
	        variant="contained"
	        color="secondary"
	        className={classes.submit}
	      >
	        Sign in with Google
	      </Button>
	      <Button
	        type="submit"
	        fullWidth
	        variant="contained"
	        color="primary"
	        className={classes.submit}
	      >
	        Sign In with Facebook
	      </Button>
	      <Button
	        type="submit"
	        fullWidth
	        variant="contained"
	        color="default"
	        className={classes.submit}
	      >
	        Sign in with Kakao
	      </Button>

	    </div>
	  </Container>

  );
}
