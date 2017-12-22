### **************************************
### ** Dynamic Web Module 3.0 — 3.1
### **************************************
I had the same problem and fixed this by editing org.eclipse.wst.common.project.facet.core.xml.
In this file, I was able to change the following line
<installed facet="jst.web" version="3.1"/>
back to
<installed facet="jst.web" version="3.0"/>
That seemed to fix the problem for me.