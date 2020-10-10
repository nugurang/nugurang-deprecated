import { withStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import React from 'react';
import PropTypes from 'prop-types';
import clsx from 'clsx';

const styles = {
  root: {
    border: '1px solid',
    borderColor: 'rgba(0, 0, 0, 0.25)',
    borderRadius: 5,
    margin: '10px',
    padding: '10px',
    variant: 'outlined',
  },
};

function ContentCard(props) {
  const { classes, children, className, ...other } = props;

  return (
    <Card className={clsx(classes.root, className)} elevation={0} {...other}>
      {children || 'Card'}
    </Card>
  );
}

ContentCard.propTypes = {
  children: PropTypes.node,
  classes: PropTypes.object.isRequired,
  className: PropTypes.string,
};

export default withStyles(styles)(ContentCard);