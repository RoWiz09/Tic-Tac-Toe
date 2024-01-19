class TicTacToe():
    def __init__(self):
        board = self.board_setup()
        self.board = board
        print(board)
    def board_setup(self):
        board = {}
        for slotx in range(3):
            for sloty in range(3):
                board[(slotx, sloty)] = " "
        return board