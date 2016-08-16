public class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    
    HashSet<String> taken;
    Deque<String> snake;
    int[][] food;
    int foodId;
    int width, height;
    int score;
    public SnakeGame(int width, int height, int[][] food) {
        this.taken = new HashSet<>();
        this.snake = new LinkedList<>();
        snake.offer(0+"-"+0);
        taken.add(0+"-"+0);
        
        this.food = food;
        this.foodId = 0;
        
        this.width = width;
        this.height = height;
        this.score = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String dir) {
        if(score == -1) return -1;
        String[] curP = snake.peek().split("-");
        int i = Integer.parseInt(curP[0]);
        int j = Integer.parseInt(curP[1]);
        
        if(dir.equals("U")) i--;
        else if(dir.equals("D")) i++;
        else if(dir.equals("L")) j--;
        else if(dir.equals("R")) j++;
        
        //new head position can be current tail position
        //so remove current tail temporarily
        taken.remove(snake.peekLast());
        
        // case 1 out boundary or eat self
        if(i < 0 || i == height || j < 0 || j == width || taken.contains(i+"-"+j)){
            score = -1;
            return -1;
        }
        
        //case 2 eat a food, keep tail and add new head
        else if(foodId < food.length && food[foodId][0] == i && food[foodId][1] == j){
            taken.add(snake.peekLast());
            taken.add(i+"-"+j);
            snake.offerFirst(i+"-"+j);
            foodId++;
            score++;
        }
        
        //case 3: no food, normal move, remove tail, add new head
        else{
            snake.pollLast();
            taken.add(i+"-"+j);
            snake.offerFirst(i+"-"+j);
        }
            
        
        
        
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */