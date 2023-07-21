# DFTB+
General purpose quantum chemical code for molecular calculations

Description & Use:
DFTB+ (authors: B. Hourahine, B. Aradi, V. Blum, F. Bonafé, A. Buccheri, C. Camacho, C. Cevallos, M. Y. Deshaye, T. Dumitrică, A. Dominguez, S. Ehlert, M. Elstner, T. van der Heide, J. Hermann, S. Irle, J. J. Kranz, C. Köhler, T. Kowalczyk, T. Kubař, I. S. Lee, V. Lutsker, R. J. Maurer, S. K. Min, I. Mitchell, C. Negre, T. A. Niehaus, A. M. N. Niklasson, A. J. Page, A. Pecchia, G. Penazzi, M. P. Persson, J. Řezáč, C. G. Sánchez, M. Sternberg, M. Stöhr, F. Stuckenberg, A. Tkatchenko, V. W.-z. Yu, T. Frauenheim) is a general, multipurpose quantum mechanical package used for performing molecular electronic structure calculations. Together with OPSIN, OpenBABEL and X11-Basic interpreter the app enables performing of a desired calculation protocol starting from either the English IUPAC name, or SMILES string, or XYZ input structure, up to custom graphical output (e.g. spectra visualization). Because the DFTB methods need parameters (Slater-Koster files), to provide all the programs features to be available offline, it was necessary to pack the Slater-Koster files to the app installer directly. Please note that the Slater-Koster files are distributed for free in homepage
https://dftb.org/parameters/download
only under the condition that all the works resulting from their use will contain the original citations included in the individual sets distributions.

IMPORTANT !!!
Although this app is composed of open-source codes and resources, licenses for some components (e.g. Slater-Koster files) require the users to cite the original references when publishing the results. Please check all the licensing information under the buttons 'License' and 'About the app'.
All the users of the DFTB+ app comply by downloading, installing and using it with all the licensing conditions of the individual software components and take the responsibility for keeping them. 

App source code: https://github.com/alanliska/DFTB+

Contact:
Compilation of the source code for Android as well as the Android app development was done by Alan Liška (alan.liska@jh-inst.cas.cz) and Veronika Růžičková (sucha.ver@gmail.com), J. Heyrovský Institute of Physical Chemistry of the CAS, v.v.i., Dolejškova 3/2155, 182 23 Praha 8, Czech Republic.
Website: http://www.jh-inst.cas.cz/~liska/MobileChemistry.htm

List of used third-party software:
ACPDFVIEW, ANDROID SHELL, BLAS, DFTB+, DFTD4, GRAPHVIEW, LAPACK, MCTC-LIB, MSTORE, MULTICHARGE, OPENBABEL, OPENBLAS, OPSIN, PYTHON, S-DFTD3, TBLITE, TEST-DRIVE, TOML-F, X11-BASIC.  

More info on licenses & references - please refer to the licensing information inside of the app.

==================================================================================================

Licenses and references to used third-party software:

 * ACPDFVIEW
 Author: Bhuvaneshw (Github)
 Source code: https://github.com/Bhuvaneshw/acpdfview
 License: GNU GPL-3.0

 * ANDROID SHELL
 Author: Jorrit "Chainfire" Jongma (JRummy Apps Inc.)
 Source code: https://github.com/aa668086/android-shell-master
 License: Apache License, Version 2.0
 
 * ARPACK
 Authors: D.C. Sorensen, R.B. Lehoucq, C. Yang, and K. Maschhoff; Allan Cornet, Sylvestre Ledru; Jordi Gutiérrez Hermoso; Sébastien Fabbro
 Source code: https://github.com/opencollab/arpack-ng
 License: BSD Software License

 * BLAS
 Source code: https://netlib.org/blas/
 License: freely-available software package

 * DFTB+
 Authors: B. Hourahine, B. Aradi, V. Blum, F. Bonafé, A. Buccheri, C. Camacho, C. Cevallos, M. Y. Deshaye, T. Dumitrică, A. Dominguez, S. Ehlert, M. Elstner, T. van der Heide, J. Hermann, S. Irle, J. J. Kranz, C. Köhler, T. Kowalczyk, T. Kubař, I. S. Lee, V. Lutsker, R. J. Maurer, S. K. Min, I. Mitchell, C. Negre, T. A. Niehaus, A. M. N. Niklasson, A. J. Page, A. Pecchia, G. Penazzi, M. P. Persson, J. Řezáč, C. G. Sánchez, M. Sternberg, M. Stöhr, F. Stuckenberg, A. Tkatchenko, V. W.-z. Yu, T. Frauenheim
 Ref.: DFTB+, a software package for efficient approximate density functional theory based atomistic simulations; J. Chem. Phys. 152, 124101 (2020).
 -DFTB+ code: B. Aradi, B. Hourahine, and Th. Frauenheim. DFTB+, a sparse matrix-based implementation of the DFTB method. J. Phys. Chem. A, 111(26):5678, 2007. 65, 131. 
 -non-SCC DFTB: D. Porezag, T. Frauenheim, T. Köhler, G. Seifert, and R. Kaschner. Construction of tightbinding-like potentials on the basis of density-functional theory: Application to carbon. Phys. Rev. B, 51:12947, 1995. 131.
                G. Seifert, D. Porezag, and T. Frauenheim. Calculations of molecules, clusters, and solids with a simplified LCAO-DFT-LDA scheme. Int. J. Quant. Chem., 58:185, 1996. 131. 
 -SCC DFTB: M. Elstner, D. Porezag, G. Jungnickel, J. Elsner, M. Haugk, T. Frauenheim, S. Suhai, and G. Seifert. Self-consistent-charge density-functional tight-binding method for simulations of complex materials properties. Phys. Rev. B, 58:7260, 1998. 54, 131. 
 -Collinear spin polarization: C. Köhler, G. Seifert, and T. Frauenheim. Density-functional based calculations for Fe(n),(n<=32). Chem. Phys., 309:23, 2005. 131. 
 -Non-collinear spin polarization, Spin orbit coupling: C. Köhler, T. Frauenheim, B. Hourahine, G. Seifert, and M. Sternberg. Treatment of collinear and noncollinear electron spin within an approximate density functional based method. J. Phys. Chem. A, 111(26):5622, 2007. 131.
 -QM/MM coupling (external charges): Q. Cui, M. Elstner, T. Frauenheim, E. Kaxiras, and M. Karplus. Combined self-consistent charge density functional tight-binding (SCC-DFTB) and CHARMM. J. Phys. Chem. B, 105:569, 2001. 131.
                                     W. Han, M. Elstner, K. J. Jalkanen, T. Frauenheim, and S. Suhai. Hybrid SCC-DFTB/molecular mechanical studies of H-bonded systems and of N-acetyl-(L-Ala)n-N’-Methylamide helices in water solution. Int. J. Quant. Chem., 78:459, 2000. 131. 
 -Van der Waals interaction (dispersion): M. Elstner, P. Hobza, T. Frauenheim, S. Suhai, and E. Kaxiras. Hydrogen bonding and stacking interactions of nucleic acid base pairs: a density-functional-theory based treatment. J. Chem. Phys., 114:5149, 2001. 45, 46, 47, 123, 131. 
 -DFTB+U: B. Hourahine, S. Sanna, B. Aradi, C. Köhler, T. Niehaus, and Th. Frauenheim. Self-interaction and strong correlation in DFTB. J. Phys. Chem. A, 111(26):5671, 2007. 42, 131. 
 -3rd order corrections: Y. Yang, H. Yu, D. York, Q. Cui, and M. Elstner. Extension of the self-consistent-charge density-functional tight-binding method: Third-order expansion of the density functional theory total energy and introduction of a modified effective coulomb interaction. J. Phys. Chem. A, 111:10861, 2007. 49, 50, 131. 
 -Linear response TD-DFTB: T. A. Niehaus, S. Suhai, F. Della Sala, P Lugli, M. Elstner, G. Seifert, and Th. Frauenheim. Tight-binding approach to time-dependent density-functional response theory. Phys. Rev. B, 63:085108, 2001. 59, 131. 
 Source code: https://github.com/dftbplus/dftbplus
 License: GNU Lesser General Public License v3
 Slater-Koster files: Creative Commons Attribution-ShareAlike 4.0 International license (for authors and references to individual sets, please see the License/LICENSING TERMS-SLATER-KOSTER-FILES, or check their homepage https://dftb.org/parameters/download/all-sk-files). For easier work in the mobile devices, all the Slater-Koster files are merged in one folder 'sk_files' and their type is distinguished in the name of the middle-separator, e.g. '-3ob-', '-mio-' etc. Please be aware that in any case of using the results for publication purposes, the authors and their works specified in the corresponding Slater-Koster file set have to be cited properly. The license permits use of their work only under the condition that their proper citing is enforced. 
 Recipes: This work is licensed under the Creative Commons Attribution-ShareAlike 4.0 International (CC BY-SA 4.0) To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/4.0/ or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.

 * DFTD4
 Authors: Eike Caldeweyher, Christoph Bannwarth, Stefan Grimme, Sebastian Ehlert, Andreas Hansen, Hagen Neugebauer, Sebastian Spicher, Jan-Michael Mewes
 Ref.: Eike Caldeweyher, Christoph Bannwarth and Stefan Grimme, J. Chem. Phys., 2017, 147, 034112. DOI: 10.1063/1.4993215
       Eike Caldeweyher, Sebastian Ehlert, Andreas Hansen, Hagen Neugebauer, Sebastian Spicher, Christoph Bannwarth and Stefan Grimme, J. Chem Phys, 2019, 150, 154122. DOI: 10.1063/1.5090222 chemrxiv: 10.26434/chemrxiv.7430216
       Eike Caldeweyher, Jan-Michael Mewes, Sebastian Ehlert and Stefan Grimme, Phys. Chem. Chem. Phys., 2020, 22, 8499-8512. DOI: 10.1039/D0CP00502A chemrxiv: 10.26434/chemrxiv.10299428
 Source code: https://github.com/dftd4/dftd4
 License: GNU GPL v3 and GNU LGPL v3

 * GBSA parameters
 Authors/contributors: please see XTB for authors and references
 Source code: https://github.com/grimme-lab/gbsa-parameters
 License: Attribution-ShareAlike 4.0 International

 * GRAPHVIEW
 Author: Jonas Gehring
 Source code: https://github.com/jjoe64
 License: Apache License, Version 2.0

 * LAPACK
 Source code: https://netlib.org/lapack/
 License: freely-available software package, modified BSD license

 * MCTC-LIB
 Authors/contributors: Sebastian Ehlert, Eisuke Kawashima, Marcel Stahn, Kjell Jorner and others (please see the source code page)
 Source code: https://github.com/grimme-lab/mctc-lib
 License: Apache v2

 * MSTORE
 Authors/contributors: Sebastian Ehlert, Kjell Jorner, Eisuke Kawashima
 Source code: https://github.com/grimme-lab/mstore
 License: Apache v2

 * MULTICHARGE
 Authors/contributors: Sebastian Ehlert, Eisuke Kawashima, Daniel Mejia-Rodriguez, Kjell Jorner
 Source code: https://github.com/grimme-lab/multicharge
 License: Apache v2

 * OPENBABEL
 Ref.: N M O'Boyle, M Banck, C A James, C Morley, T Vandermeersch, and G R Hutchison. "Open Babel: An open chemical toolbox." J. Cheminf. (2011), 3, 33. DOI:10.1186/1758-2946-3-33
       The Open Babel Package, version 2.3.1 http://openbabel.org (accessed Oct 2011)
 Source code: http://openbabel.org/wiki/Main_Page, https://github.com/openbabel/openbabel, https://sourceforge.net/projects/openbabel/

 * OPENBLAS
 Authors: Zhang Xianyi, Wang Qian, Zaheer Chothia
 Ref.: Xianyi, Z., Qian, W., & Chothia, Z. (2012). OpenBLAS. URL: http://xianyi. github. io/OpenBLAS, 88.
 Source code: https://github.com/xianyi/OpenBLAS
 License: BSD3-Clause

 * OPSIN
 Authors/developers: Rich Apodaca, Albina Asadulina, Peter Corbett, Daniel Lowe (Current maintainer), John Mayfield, Peter Murray-Rust, Noel O'Boyle, Mark Williamson
 Ref.: Lowe, Daniel M., Peter T. Corbett, Peter Murray-Rust, and Robert C. Glen. "Chemical name to structure: OPSIN, an open source solution." (2011): 739-753.
 Source code: https://github.com/dan2097/opsin
 License: MIT License

 * PYTHON
 Source code: https://www.python.org/downloads/source/
 License: PSF license agreement, check the homepage https://docs.python.org/3.7/license.html for details

 * S-DFTD3
 Authors/contributors: Sebastian Ehlert, Robert Cohn, Eisuke Kawashima, Shirong Wang, Kjell Jorner and others (please see the source code page)
 Ref.: S. Grimme, J. Antony, S. Ehrlich and H. Krieg J. Chem. Phys, 132 (2010), 154104.
       S. Grimme, S. Ehrlich and L. Goerigk J. Comput. Chem, 32 (2011), 1456-1465.
 Source code: https://github.com/dftd3/simple-dftd3
 License: GNU GPL v3 and GNU LGPL v3

 * TBLITE
 Authors/contributors: Sebastian Ehlert, Daniel Mejia-Rodriguez, Marvin Friede, Zeyuan Tang, Hagen Neugebauer, Konstantin Karandashev and others (please see the source code page)
 Source code: https://github.com/tblite/tblite
 License: GNU GPL v3 and GNU LGPL v3

 * TOML-F
 Authors/contributors: Sebastian Ehlert, Robert Cohn, Bálint Aradi, Asdrubal Lozada-Blanco, Rohit Goswami, Ben Hourahine, Emily Kahl, Daniel Mejia-Rodriguez, Kjell Jorner
 Source code: https://github.com/toml-f/toml-f
 License: Apache v2, MIT

 * X11-BASIC
 Author: Markus Hoffmann
 Source code: https://github.com/kollokollo/X11Basic
 License: GPL-2.0



Other references:

 * UV-Vis spectra convolution: Tirri, Bernardino. Détermination d’un protocole de calcul pour la prédiction de spectres UV-vis de molécules en solution. Diss. Université Paris sciences et lettres, 2022.

Info on licenses: please see the full-text licenses under the button Licenses. 