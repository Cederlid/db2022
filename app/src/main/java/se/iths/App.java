package se.iths;

import java.sql.SQLException;
import java.util.Collection;

public class App {
  
  public static void main(String[] args){
    App app = new App();

  }

  private void load() throws SQLException{
    Collection<Artist> artists = loadArtists();
  }

}