from sklearn.neighbors import NearestNeighbors
import numpy as np
'''
# https://scikit-learn.org/stable/modules/neighbors.html
X = np.array([[-1, -1], [-2, -1], [-3, -2], [1, 1], [2, 1], [3, 2]])
nbrs = NearestNeighbors(n_neighbors=4, algorithm='ball_tree').fit(X)
print(nbrs)
distances, indices = nbrs.kneighbors(X)
print(indices)
print(distances)
'''

users = {
    'binkoni': {
        'upvoted': [
            'hello world',
            'goodbye world'
        ],
        'downvoted': [
            'hell',
            'no'
        ]
    },
    'snapperbay': {
        'upvoted': [
            'hello',
            'lorem ipsum'
        ],
        'downvoted': [
            'blabla',
            'nah'
        ]
    }
}

print(users['binkoni'])
