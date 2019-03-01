package algorithms;

public class LargestRegion {

  static int[][] matrix = {
      {0, 1, 0, 1, 1},
      {0, 1, 1, 0, 0},
      {0, 1, 1, 1, 0},
      {0, 0, 0, 0, 1},
      {0, 1, 1, 1, 1}
  };

  public int DFS(int height, int width, int startRow, int startColumn, int area) {
    if (startRow == height || startColumn == width || startColumn == -1) {
      return area;
    }
    if (matrix[startRow][startColumn] == 1) {
      ++area;
      matrix[startRow][startColumn] = 0;
      area = DFS(height, width, startRow + 1, startColumn, area);
      area = DFS(height, width, startRow, startColumn + 1, area);
      area = DFS(height, width, startRow, startColumn - 1, area);
    }
    return area;
  }

  public int calculateLargestIsland(int height, int width) {
    int maxArea = 0;
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        if (matrix[i][j] == 1) {
          int area = DFS(height, width, i, j, 0);
          if (area > maxArea) {
            maxArea = area;
          }
        }
      }
    }
    return maxArea;
  }

  public static void main(String[] args) {
    LargestRegion lr = new LargestRegion();
    System.out.println(lr.calculateLargestIsland(5, 5));
  }
}
