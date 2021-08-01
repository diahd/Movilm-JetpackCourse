package com.jetpackcourse1.movilm.utils

import com.jetpackcourse1.movilm.R
import com.jetpackcourse1.movilm.data.DataEntity

object DataDummy {
    fun generateDummyMovies(): List<DataEntity>{

        val movies = ArrayList<DataEntity>()

        movies.add(DataEntity(R.drawable.poster_a_start_is_born,
            "A Star Is Born",
            "2018",
            "R",
            "10/05/2018",
            "Drama, Romance, Music",
            "2h 16m",
            "75/100",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "Bradley Cooper"))

        movies.add(DataEntity(R.drawable.poster_alita,
            "Alita: Battle Angel",
            "2019",
            "PG-13",
            "02/14/2019",
            "Action, Science Fiction, Adventure",
            "2h 2m",
            "72/100",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "Robert Rodriguez")
        )

        movies.add(DataEntity(R.drawable.poster_aquaman,
            "Aquaman",
            "2018",
            "PG-13",
            "12/21/2018",
            "Action, Adventure, Fantasy",
            "2h 23m",
            "69/100",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "James Wan"))

        movies.add(DataEntity(R.drawable.poster_bohemian,
            "Bohemian Rhapsody",
            "2018",
            "PG-13",
            "11/02/2018",
            "Music, Drama, History",
            "2h 15m",
            "80/100",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "Bryan Singer"))

        movies.add(DataEntity(R.drawable.poster_cold_persuit,
            "Cold Pursuit",
            "2019",
            "R",
            "02/08/2019",
            "Action, Crime, Thriller",
            "1h 59m",
            "57/100",
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            "Hans Petter Moland"))

        movies.add(DataEntity(R.drawable.poster_how_to_train,
            "How to Train Your Dragon: The Hidden World",
            "2019",
            "PG",
            "02/22/2019",
            "Animation, Family, Adventure",
            "1h 44m",
            "78/100",
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
            "Dean DeBlois"))

        movies.add(DataEntity(R.drawable.poster_infinity_war,
            "Avengers: Infinity War",
            "2018",
            "PG-13",
            "04/27/2018",
            "Adventure, Action, Science Fiction",
            "2h 29m",
            "83/100",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "Anthony Russo"))

        movies.add(DataEntity(R.drawable.poster_marry_queen,
            "Mary Queen of Scots",
            "2018",
            "R",
            "12/21/2018",
            "Drama, History",
            "2h 4m",
            "66/100",
            "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
            "Josie Rourke"))

        movies.add(DataEntity(R.drawable.poster_robin_hood,
            "Robin Hood",
            "2018",
            "PG-13",
            "11/21/2018",
            "Adventure, Action, Thriller",
            "1h 56m",
            "59/100",
            "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
            "Otto Bathurst"))

        movies.add(DataEntity(R.drawable.poster_spiderman,
            "Spider-Man: Into the Spider-Verse",
            "2018",
            "PG",
            "12/14/2018",
            "Action, Adventure, Animation, Science Fiction, Comedy",
            "1h 57m",
            "84/100",
            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
            "Rodney Rothman"))

        return movies
    }

    fun generateDummyTVShows(): List<DataEntity> {

        val tvshows = ArrayList<DataEntity>()

        tvshows.add(
            DataEntity(R.drawable.poster_arrow ,
            "Arrow",
            "2012",
            "TV-14",
            "10/10/2012",
            "Crime, Drama, Mystery, Action & Adventure\n",
            "42m",
            "66/100",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "Greg Berlanti")
        )

        tvshows.add(DataEntity(R.drawable.poster_doom_patrol ,
            "Doom Patrol",
            "2019",
            "TV-MA",
            "15/02/2019",
            "Sci-Fi & Fantasy, Comedy, Drama",
            "49m",
            "76/100",
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "Jeremy Carver"))

        tvshows.add(DataEntity(R.drawable.poster_shameless ,
            "Shameless",
            "2004",
            "18",
            "13/01/2004",
            "Comedy, Drama",
            "1h",
            "76/100",
            "The story of a young group of siblings pretty much abandoned by their parents, surviving by their wits - and humor - on a rough Manchester council estate. Whilst they won't admit it, they need help and find it in Steve, a young middle class lad who falls for Fiona, the oldest sibling, and increasingly finds himself drawn to this unconventional and unique family. Anarchic family life seen through the eyes of an exceptionally bright fifteen year old, who struggles to come of age in the context of his belligerent father, closeted brother, psychotic sister and internet porn star neighbors.",
            "Paul Abbott"))

        tvshows.add(DataEntity(R.drawable.poster_family_guy ,
            "Family Guy",
            "1999",
            "TV-14",
            "31/01/1999",
            "Animation, Comedy",
            "22m",
            "70/100",
            "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            "Seth MacFarlane"))

        tvshows.add(DataEntity(R.drawable.poster_flash ,
            "The Flash",
            "2014",
            "TV-14",
            "07/10/2014",
            "Drama, Sci-Fi & Fantasy",
            "44m",
            "77/100",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "Greg Berlanti, Geoff Johns, Andrew Kreisberg"))

        tvshows.add(DataEntity(R.drawable.poster_hanna ,
            "Hanna",
            "2019",
            "TV-MA",
            "28/03/2019",
            "Action & Adventure, Drama",
            "50m",
            "75/100",
            "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            "David Farr"))

        tvshows.add(DataEntity(R.drawable.poster_riverdale ,
            "Riverdale",
            "2017",
            "TV-14",
            "26/01/2017",
            "Mystery, Drama, Crime",
            "45m",
            "86/100",
            "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
            "Roberto Aguirre Sacasa"))

        tvshows.add(DataEntity(R.drawable.poster_supergirl ,
            "Supergirl",
            "2015",
            "TV-14",
            "26/10/2015",
            "Drama, Sci-Fi & Fantasy, Action & Adventure",
            "42m",
            "72/100",
            "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
            "Greg Berlanti, Ali Adler, Andrew Kreisberg"))

        tvshows.add(DataEntity(R.drawable.poster_the_simpson ,
            "The Simpsons",
            "1989",
            "TV-PG",
            "17/12/1989",
            "Family, Animation, Comedy",
            "22m",
            "78/100",
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            "Matt Groening"))

        tvshows.add(DataEntity(R.drawable.poster_the_umbrella ,
            "The Umbrella Academy",
            "2019",
            "TV-MA",
            "15/02/2019",
            "Action & Adventure, Sci-Fi & Fantasy, Drama",
            "55m",
            "87/100",
            "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
            "Steve Blackman"))

        return tvshows
    }
}