---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy:
  - icon: ':x:'
    path: library/Dijkstra.java
    title: library/Dijkstra.java
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':warning:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/DistCalc.java\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\n\nabstract\
    \ class DistCalc { // V=numNode, E=numEdge\n\tprotected static final class Dist\
    \ implements Comparable<Dist> {\n\t\tpublic int target;\n\t\tpublic long cost;\n\
    \t\tpublic Dist(final int target, final long cost) { this.target = target; this.cost\
    \ = cost; }\n\t\t@Override public final String toString() { return \" - \"+cost+\"\
    \ -> \"+target; }\n\t\t@Override public final int hashCode() { return Long.hashCode(target);\
    \ }\n\t\t@Override\n\t\tpublic final boolean equals(final Object obj) {\n\t\t\t\
    if(this == obj) return true;\n\t\t\tif(obj == null) return false;\n\t\t\tif(this.getClass()\
    \ != obj.getClass()) return false;\n\t\t\tDist that = (Dist) obj;\n\t\t\tif(this.target\
    \ != that.target) return false;\n\t\t\tif(this.cost != that.cost) return false;\n\
    \t\t\treturn true;\n\t\t}\n\t\t@Override\n\t\tpublic final int compareTo(final\
    \ Dist that) {\n\t\t\tint c = Long.compare(this.cost, that.cost);\n\t\t\tif(c\
    \ == 0) c = Integer.compare(this.target, that.target);\n\t\t\treturn c;\n\t\t\
    }\n\t}\n\n\tpublic static int prv[];\n\tpublic static final int[] getPass(final\
    \ int start, int goal) { // O(V)\n\t\tSimpleUtil.rangeCheck(start, prv.length);\n\
    \t\tSimpleUtil.rangeCheck(goal, prv.length);\n\t\tfinal Deque<Integer> passList\
    \ = new ArrayDeque<>();\n\t\tpassList.addLast(goal);\n\t\twhile(goal != start)\
    \ passList.addLast(goal = prv[goal]);\n\t\tfinal int pass[] = new int[passList.size()];\n\
    \t\tfor(int i = 0; i < pass.length; i ++) pass[i] = passList.removeLast();\n\t\
    \treturn pass;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/DistCalc.java
  requiredBy:
  - library/Dijkstra.java
  timestamp: '2022-10-01 13:17:40+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: library/DistCalc.java
layout: document
redirect_from:
- /library/library/DistCalc.java
- /library/library/DistCalc.java.html
title: library/DistCalc.java
---
