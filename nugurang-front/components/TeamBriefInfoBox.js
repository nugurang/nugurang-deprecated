import React, { Component } from 'react';
import MuiThemeProvider from '@material-ui/core/styles/MuiThemeProvider';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Avatar from '@material-ui/core/Avatar';
import Box from '@material-ui/core/Box';
import CssBaseline from '@material-ui/core/CssBaseline';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import Paper from '@material-ui/core/Paper';

const styles = theme => ({
  avatar: {
    fontSize: 36,
    height: '75px', 
    margin: '0px',
    width: '75px'
  },
  box: {
    border: '0px solid',
    borderColor: 'rgba(0, 0, 0, 0.25)',
    borderRadius: 5,
    margin: '5px',
    padding: '0px',
    variant: 'outlined',
  },
  nameTypography: {
    whiteSpace: "nowrap",
    fontFamily: "Ubuntu",
    fontSize: 28,
    fontWeight: 400,
    margin: '0px',
  },
  bioTypography: {
    fontFamily: "Ubuntu",
    fontSize: 24,
    fontWeight: 300,
    margin: '0px 10px',
  },
});


function TeamBriefInfoBox(props) {

  const { classes } = props;

  return (
    <React.Fragment>
      <CssBaseline />
      <Box className={classes.box}>
        <Grid container spacing={2} alignItems="center" direction="row" justify="flex-start">
          <Grid item align="center">
            <Avatar
              className={classes.avatar}
              alt={props.user.name}
              src={props.user.image}
            />
          </Grid>
          <Grid item align="left">
            <Typography className={classes.nameTypography}>{props.user.name}</Typography>
          </Grid>
        </Grid>
      </Box>
      <Paper className={classes.bioPaper} variant='outlined'>
        <Typography className={classes.bioTypography}>
          {props.user.bio}
        </Typography>
      </Paper>
    </React.Fragment>
  );
}

TeamBriefInfoBox.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(TeamBriefInfoBox);