import { withStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import React from 'react';
import PropTypes from 'prop-types';
import clsx from 'clsx';

const styles = {
  root: {
    border: '0px solid',
    borderColor: 'rgba(0, 0, 0, 0.25)',
    borderRadius: 5,
    margin: '0px 15px',
    padding: '0px',
    variant: 'outlined',
  },
};

function PageTitlePaper(props) {
  const { classes, children, className, ...other } = props;

  return (
    <Paper className={clsx(classes.root, className)} elevation={0} {...other}>
      {children || 'Paper'}
    </Paper>
  );
}

PageTitlePaper.propTypes = {
  children: PropTypes.node,
  classes: PropTypes.object.isRequired,
  className: PropTypes.string,
};

export default withStyles(styles)(PageTitlePaper);