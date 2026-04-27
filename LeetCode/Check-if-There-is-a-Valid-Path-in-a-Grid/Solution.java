     directions = {
        1: [(0, -1), (0, 1)],  # Street 1: Horizontal (left, right)
        2: [(1, 0), (-1, 0)],  # Street 2: Vertical (down, up)
        3: [(0, -1), (1, 0)],  # Street 3: Left-Down (left, down)
        4: [(0, 1), (1, 0)],   # Street 4: Right-Down (right, down)
        5: [(0, -1), (-1, 0)], # Street 5: Left-Up (left, up)
        6: [(0, 1), (-1, 0)]   # Street 6: Right-Up (right, up)
    }

    valid = {
        1: [(1, 4, 6), (1, 3, 5)],  # Street 1: Valid connections for right and left
        2: [(2, 5, 6), (2, 3, 4)],  # Street 2: Valid connections for down and up
        3: [(1, 4, 6), (2, 5, 6)],  # Street 3: Valid connections for left and down
        4: [(1, 3, 5), (2, 5, 6)],  # Street 4: Valid connections for right and down
        5: [(1, 4, 6), (2, 3, 4)],  # Street 5: Valid connections for left and up
        6: [(1, 3, 5), (2, 3, 4)]   # Street 6: Valid connections for right and up
    }