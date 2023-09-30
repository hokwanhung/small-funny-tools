import copy
# Farmer, Goat, Wolf and Cabbage


#######################
## Data Structures ####
#######################
#  The following is how the state is represented during a search.
#  A dictionary format is chosen for the convenience and quick access

LEFT = 0
RIGHT = 1
BOAT_POSITION = 2
Wolf = 0
Goat = 1
Cabbage = 2

# [[num_Goat_left, num_Wolf_left, num_Cabbage_left], [num_Goat_right, num_Wolf_right. num_Cabbage_right], boat_position (0=left, 1=right)]
initial_state = [[1, 1, 1], [0, 0, 0], LEFT]
goal_state = [[0, 0, 0], [1, 1, 1], RIGHT]


###################################################
# Functions related to the game
###################################################


# Verifies if the state is safe.

def is_safe(state):

    return ((state[BOAT_POSITION] == LEFT and state[LEFT][Goat] == 1) or
            (state[BOAT_POSITION] == RIGHT and state[RIGHT][Goat] == 1) or
            (state[BOAT_POSITION] == LEFT and (state[RIGHT][Wolf] != state[RIGHT][Goat] and state[RIGHT][Goat] != state[RIGHT][Cabbage])) or
            (state[BOAT_POSITION] == RIGHT and (state[LEFT][Wolf] !=
                                                state[LEFT][Goat] and state[LEFT][Goat] != state[LEFT][Cabbage]))
            )


def opposite_side(side):
    if side == LEFT:
        return RIGHT
    else:
        return LEFT

##############################################
## Functions for recording the path #########
##############################################

#
# A path is the states from the root to a certain goal node
# It is represented as a List of states from the root
# The create_path function create a new path by add one more node to an old path
#


def create_path(old_path, state):
    new_path = old_path.copy()
    new_path.append(state)
    return new_path

##########################
# Functions for Searching
##########################


def move(state, Wolves, Goats, Cabbages):
    side = state[BOAT_POSITION]
    opposite = opposite_side(side)

    if state[side][Wolf] >= Wolves and state[side][Goat] >= Goats and state[side][Cabbage] >= Cabbages:
        new_state = copy.deepcopy(state)  # Copy an object inside an object
        new_state[side][Wolf] -= Wolves
        new_state[opposite][Wolf] += Wolves
        new_state[side][Goat] -= Goats
        new_state[opposite][Goat] += Goats
        new_state[side][Cabbage] -= Cabbages
        new_state[opposite][Cabbage] += Cabbages
        new_state[BOAT_POSITION] = opposite

    return new_state


# Find out the possible moves, and return them as a list
def find_children(old_state):
    children = []
    side = old_state[BOAT_POSITION]

    # Try to move one Wolf
    if old_state[side][Wolf] == 1:
        new_state = move(old_state, Wolves=1, Goats=0, Cabbages=0)

        if is_safe(new_state):
            children.append(new_state)

    # Try to move one Goat
    if old_state[side][Goat] == 1:
        new_state = move(old_state, Wolves=0, Goats=1, Cabbages=0)

        if is_safe(new_state):
            children.append(new_state)

    # Try to move one Cabbage
    if old_state[side][Cabbage] == 1:
        new_state = move(old_state, Wolves=0, Goats=0, Cabbages=1)

        if is_safe(new_state):
            children.append(new_state)

    # Travel with nothing
    if old_state[side]:
        new_state = move(old_state, Wolves=0, Goats=0, Cabbages=0)

        if is_safe(new_state):
            children.append(new_state)

    return children

#  ---------------------------
# Search routine ####
#  ---------------------------


def bfs_search(start_state):

    visited = []
    to_visit = []

    path = create_path([], start_state)
    next_node = [start_state, path]

    end = False
    while not end:

        next_state, path = next_node

        if not next_state in visited:

            visited.append(next_state)
            if next_state == goal_state:

                return path
            else:
                for child_state in find_children(next_state):
                    child_path = create_path(path, child_state)
                    to_visit.append([child_state, child_path])

        if to_visit:
            next_node = to_visit.pop(0)
        else:
            print("Failed to find a goal state")
            end = True
            return ()


################
## Main   ######
################

# Search for a solution
path = bfs_search(initial_state)

if path:
    print("Path from start to goal:")
    for p in path:  # path = bfs_search(initial_state)
        left, right, side = p
        w_left, g_left, c_left = left
        w_right, g_right, c_right = right

        if side == LEFT:
            boat_l = "#BOAT#"
            boat_r = "      "
        else:
            boat_l = "      "
            boat_r = "#BOAT#"
        print(" Wolf {}  Goat {}  Cabbage {} {} |~~~~~| {}  Wolf {}  Goat {} Cabbage {}" .format(
            w_left, g_left, c_left, boat_l, boat_r, w_right, g_right, c_right))

input()
