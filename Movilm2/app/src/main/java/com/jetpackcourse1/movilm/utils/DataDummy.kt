package com.jetpackcourse1.movilm.utils

import com.jetpackcourse1.movilm.R
import com.jetpackcourse1.movilm.data.DataEntity
import com.jetpackcourse1.movilm.data.DataGenre
import com.jetpackcourse1.movilm.data.source.remote.response.GenresItemMovie
import com.jetpackcourse1.movilm.data.source.remote.response.GenresItemTV
import com.jetpackcourse1.movilm.data.source.remote.response.ResultsItem
import com.jetpackcourse1.movilm.data.source.remote.response.ResultsItemTV

object DataDummy {
    fun generateDummyMovies(): List<DataEntity>{

        val movies = ArrayList<DataEntity>()

        movies.add(DataEntity(
                poster = "https://image.tmdb.org/t/p/w185/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
                id = 460465,
                title = "Mortal Kombat",
                date = "2021-04-07",
                score = "7.8/10",
                overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe."
        ))

        movies.add(DataEntity("${R.drawable.poster_alita}",
            2,
            "Alita: Battle Angel",
            "02/14/2019",
            "72/100",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past."
        ))

        movies.add(DataEntity("${R.drawable.poster_aquaman}",
            3,
            "Aquaman",
            "12/21/2018",
            "69/100",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."
        ))

        movies.add(DataEntity("${R.drawable.poster_bohemian}",
            4,
            "Bohemian Rhapsody",
            "11/02/2018",
            "80/100",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."
        ))

        movies.add(DataEntity("${R.drawable.poster_cold_persuit}",
            5,
            "Cold Pursuit",
            "02/08/2019",
            "57/100",
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution."
        ))

        movies.add(DataEntity("${R.drawable.poster_how_to_train}",
            6,
            "How to Train Your Dragon: The Hidden World",
            "02/22/2019",
            "78/100",
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind."
        ))

        movies.add(DataEntity("${R.drawable.poster_infinity_war}",
            7,
            "Avengers: Infinity War",
            "04/27/2018",
            "83/100",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."
        ))

        movies.add(DataEntity("${R.drawable.poster_marry_queen}",
            8,
            "Mary Queen of Scots",
            "12/21/2018",
            "66/100",
            "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled."
        ))

        movies.add(DataEntity("${R.drawable.poster_robin_hood}",
            9,
            "Robin Hood",
            "11/21/2018",
            "59/100",
            "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown."
        ))

        movies.add(DataEntity("${R.drawable.poster_spiderman}",
            10,
            "Spider-Man: Into the Spider-Verse",
            "12/14/2018",
            "84/100",
            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension."
        ))

        return movies
    }

    fun generateDummyTVShows(): List<DataEntity> {

        val tvshows = ArrayList<DataEntity>()

        tvshows.add(DataEntity("${R.drawable.poster_arrow}" ,
            1,
            "Arrow",
            "10/10/2012",
            "66/100",
            "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives"
        ))

        tvshows.add(DataEntity("${R.drawable.poster_doom_patrol}" ,
            2,
            "Doom Patrol",
            "15/02/2019",
            "76/100",
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
        ))

        tvshows.add(DataEntity("${R.drawable.poster_shameless}" ,
            3,
            "Shameless",
            "13/01/2004",
            "76/100",
            "The story of a young group of siblings pretty much abandoned by their parents, surviving by their wits - and humor - on a rough Manchester council estate. Whilst they won't admit it, they need help and find it in Steve, a young middle class lad who falls for Fiona, the oldest sibling, and increasingly finds himself drawn to this unconventional and unique family. Anarchic family life seen through the eyes of an exceptionally bright fifteen year old, who struggles to come of age in the context of his belligerent father, closeted brother, psychotic sister and internet porn star neighbors.",
        ))

        tvshows.add(DataEntity("${R.drawable.poster_family_guy}" ,
            4,
            "Family Guy",
            "31/01/1999",
            "70/100",
            "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
        ))

        tvshows.add(DataEntity("${R.drawable.poster_flash}" ,
            5,
            "The Flash",
            "07/10/2014",
            "77/100",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
        ))

        tvshows.add(DataEntity("${R.drawable.poster_hanna}" ,
            6,
            "Hanna",
            "28/03/2019",
            "75/100",
            "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
        ))

        tvshows.add(DataEntity("${R.drawable.poster_riverdale}" ,
            7,
            "Riverdale",
            "26/01/2017",
            "86/100",
            "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
        ))

        tvshows.add(DataEntity("${R.drawable.poster_supergirl}" ,
            8,
            "Supergirl",
            "26/10/2015",
            "72/100",
            "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
        ))

        tvshows.add(DataEntity("${R.drawable.poster_the_simpson}" ,
            9,
            "The Simpsons",
            "17/12/1989",
            "78/100",
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
        ))

        tvshows.add(DataEntity("${R.drawable.poster_the_umbrella}" ,
            10,
            "The Umbrella Academy",
            "15/02/2019",
            "87/100",
            "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
        ))

        return tvshows
    }

    fun generateDummyMovieGenre(): List<DataGenre> {

        val movieGenre = ArrayList<DataGenre>()

        movieGenre.add(DataGenre("Drama", 18))
        movieGenre.add(DataGenre("Sci-Fi & Fantasy", 10765))

        return movieGenre
    }

    fun generateDummyTVGenre(): List<DataGenre> {

        val tvGenre = ArrayList<DataGenre>()

        tvGenre.add(DataGenre("Fantasy", 14))
        tvGenre.add(DataGenre("Action", 28))
        tvGenre.add(DataGenre("Adventure",12))
        tvGenre.add(DataGenre("Science Fiction",878))
        tvGenre.add(DataGenre("Thriller",53))

        return tvGenre
    }

    fun generateDummyMoviesRemote(): List<ResultsItem>{

        val movies = ArrayList<ResultsItem>()
        val genre = ArrayList<GenresItemMovie>()

        movies.add(ResultsItem(posterPath = "https://image.tmdb.org/t/p/w185/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
            id = 460465,
            title = "Mortal Kombat",
            releaseDate = "2021-04-07",
            voteAverage = 7.9,
                genres = genre,
            overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe."
        ))

        movies.add(
            ResultsItem(posterPath = "${R.drawable.poster_alita}",
                id = 2,
                title = "Alita: Battle Angel",
                releaseDate = "02/14/2019",
                voteAverage = 7.2,
                genres = genre,
                overview = "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past."
            ))

        movies.add(
            ResultsItem(posterPath = "${R.drawable.poster_aquaman}",
                id = 3,
                title = "Aquaman",
                releaseDate = "12/21/2018",
                genres = genre,
                voteAverage = 6.9,
                overview = "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."
            ))

        movies.add(
            ResultsItem(posterPath = "${R.drawable.poster_bohemian}",
                id = 4,
                title = "Bohemian Rhapsody",
                releaseDate = "11/02/2018",
                genres = genre,
                voteAverage = 8.0,
                overview = "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."
            ))

        movies.add(ResultsItem(posterPath = "${R.drawable.poster_cold_persuit}",
            id = 5,
            title = "Cold Pursuit",
            genres = genre,
            releaseDate = "02/08/2019",
            voteAverage = 5.7,
            overview = "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution."
        ))

        movies.add(ResultsItem(posterPath = "${R.drawable.poster_how_to_train}",
            id = 6,
            title = "How to Train Your Dragon: The Hidden World",
            releaseDate = "02/22/2019",
            genres = genre,
            voteAverage = 7.8,
            overview = "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind."
        ))

        movies.add(ResultsItem(posterPath = "${R.drawable.poster_infinity_war}",
            id = 7,
            title = "Avengers: Infinity War",
            releaseDate = "04/27/2018",
            genres = genre,
            voteAverage = 8.3,
            overview = "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."
        ))

        movies.add(ResultsItem(posterPath = "${R.drawable.poster_marry_queen}",
            id = 8,
            title = "Mary Queen of Scots",
            releaseDate = "12/21/2018",
            genres = genre,
            voteAverage = 6.6,
            overview = "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled."
        ))

        movies.add(ResultsItem(posterPath = "${R.drawable.poster_robin_hood}",
            id = 9,
            title = "Robin Hood",
            releaseDate = "11/21/2018",
            genres = genre,
            voteAverage = 5.9,
            overview = "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown."
        ))

        movies.add(ResultsItem(posterPath = "${R.drawable.poster_spiderman}",
            id = 10,
            title = "Spider-Man: Into the Spider-Verse",
            genres = genre,
            releaseDate = "12/14/2018",
            voteAverage = 8.4,
            overview = "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension."
        ))

        return movies
    }

    fun generateDummyTVShowsRemote(): List<ResultsItemTV> {

        val tvshows = ArrayList<ResultsItemTV>()
        val genre = ArrayList<GenresItemTV>()

        tvshows.add(ResultsItemTV(posterPath = "${R.drawable.poster_arrow}" ,
            id = 1,
            originalName = "Arrow",
            genres = genre,
            firstAirDate = "10/10/2012",
            voteAverage = 6.6,
            overview = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives"
        ))

        tvshows.add(ResultsItemTV(posterPath = "${R.drawable.poster_doom_patrol}" ,
            id = 2,
            originalName = "Doom Patrol",
            firstAirDate = "15/02/2019",
            genres = genre,
            voteAverage = 7.6,
            overview = "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
        ))

        tvshows.add(ResultsItemTV(posterPath = "${R.drawable.poster_shameless}" ,
            id = 3,
            originalName = "Shameless",
            genres = genre,
            firstAirDate = "13/01/2004",
            voteAverage = 7.6,
            overview = "The story of a young group of siblings pretty much abandoned by their parents, surviving by their wits - and humor - on a rough Manchester council estate. Whilst they won't admit it, they need help and find it in Steve, a young middle class lad who falls for Fiona, the oldest sibling, and increasingly finds himself drawn to this unconventional and unique family. Anarchic family life seen through the eyes of an exceptionally bright fifteen year old, who struggles to come of age in the context of his belligerent father, closeted brother, psychotic sister and internet porn star neighbors.",
        ))

        tvshows.add(ResultsItemTV(posterPath = "${R.drawable.poster_family_guy}" ,
            id = 4,
            originalName = "Family Guy",
            genres = genre,
            firstAirDate = "31/01/1999",
            voteAverage = 7.0,
            overview = "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
        ))

        tvshows.add(ResultsItemTV(posterPath = "${R.drawable.poster_flash}" ,
            id = 5,
            originalName = "The Flash",
            genres = genre,
            firstAirDate = "07/10/2014",
            voteAverage = 7.7,
            overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
        ))

        tvshows.add(ResultsItemTV(posterPath = "${R.drawable.poster_hanna}" ,
            id = 6,
            originalName = "Hanna",
            genres = genre,
            firstAirDate = "28/03/2019",
            voteAverage = 7.5,
            overview = "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
        ))

        tvshows.add(ResultsItemTV(posterPath = "${R.drawable.poster_riverdale}" ,
            id = 7,
            originalName = "Riverdale",
            genres = genre,
            firstAirDate = "26/01/2017",
            voteAverage = 8.6,
            overview = "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
        ))

        tvshows.add(ResultsItemTV(posterPath = "${R.drawable.poster_supergirl}" ,
            id = 8,
            originalName = "Supergirl",
            genres = genre,
            firstAirDate = "26/10/2015",
            voteAverage = 7.2,
            overview = "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
        ))

        tvshows.add(ResultsItemTV(posterPath = "${R.drawable.poster_the_simpson}" ,
            id = 9,
            originalName = "The Simpsons",
            genres = genre,
            firstAirDate = "17/12/1989",
            voteAverage = 7.8,
            overview = "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
        ))

        tvshows.add(ResultsItemTV(posterPath = "${R.drawable.poster_the_umbrella}" ,
            id = 10,
            originalName = "The Umbrella Academy",
            genres = genre,
            firstAirDate = "15/02/2019",
            voteAverage = 8.7,
            overview = "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
        ))

        return tvshows
    }

    fun generateDummyMovieGenreRemote(): List<GenresItemMovie> {

        val movieGenre = ArrayList<GenresItemMovie>()

        movieGenre.add(GenresItemMovie("Drama", 18))
        movieGenre.add(GenresItemMovie("Sci-Fi & Fantasy", 10765))

        return movieGenre
    }

    fun generateDummyTVGenreRemote(): List<GenresItemTV> {

        val tvGenre = ArrayList<GenresItemTV>()

        tvGenre.add(GenresItemTV("Fantasy", 14))
        tvGenre.add(GenresItemTV("Action", 28))
        tvGenre.add(GenresItemTV("Adventure",12))
        tvGenre.add(GenresItemTV("Science Fiction",878))
        tvGenre.add(GenresItemTV("Thriller",53))

        return tvGenre
    }
}