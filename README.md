# AstronomicalCalculations


AstronomicalCalculations is a library for astronomical calulations, duh.
The Formulars are from: 
 - Duffett Smith, Peter: Practical astronomy with your calculator (1979) 
 Cambridge: Cambridge University Press


## Features

- Position: Ecliptic, Equatorial and Horizon 
- Rise- and set Time
- Distance from Earth 
from Sun, Moon and Planets (incl. Pluto)

## Installation
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:


```sh	
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency

```sh
dependencies {
		implementation 'com.github.ayaigi:AstronomicalCalculations:6.1.0'
	}
```

## Use
Use the 'Astronomy'-class for the configuration and it's member function 'calc' together with the Target(use 'SolarSystemTargets'-class) for the Results

## Development

I'm working on Implementing Constellations and Stars
