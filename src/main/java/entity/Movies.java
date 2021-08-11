package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Movies {

    private int MovieID;
    private String Movies;
    private int DirectorKey;
    private int StudioKey;
    private int RunningTime;
    private int Budget;
    private int BoxOffice;
    private int CountryKey;
    private int LanguageKey;
    private int Year;

    public Movies(String movies, int directorKey, int studioKey, int runningTime, int budget, int boxOffice, int countryKey, int languageKey, int year) {
        Movies = movies;
        DirectorKey = directorKey;
        StudioKey = studioKey;
        RunningTime = runningTime;
        Budget = budget;
        BoxOffice = boxOffice;
        CountryKey = countryKey;
        LanguageKey = languageKey;
        Year = year;
    }
}
