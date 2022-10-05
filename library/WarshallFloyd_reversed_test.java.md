---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/WarshallFloyd.java
    title: library/WarshallFloyd.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=2005
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=2005\n\
    \npackage library;\n\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.WarshallFloyd;\n\npublic class WarshallFloyd_reversed_test extends\
    \ Solver {\n\tpublic static void main(final String[] args) { main(args, new WarshallFloyd_reversed_test());\
    \ }\n\n\tpublic void solve() {\n\t\twhile(true) {\n\t\t\tint n = ni();\n\t\t\t\
    int m = ni();\n\t\t\tint s = ni() - 1;\n\t\t\tint g1 = ni() - 1;\n\t\t\tint g2\
    \ = ni() - 1;\n\t\t\tif(n == 0) return;\n\t\t\tvar g = new ArrayWeightedGraph(n,\
    \ true);\n\t\t\tfor(int i = 0; i < m; i ++) g.add(ni() - 1, ni() - 1, nl());\n\
    \t\t\tlong distS[] = WarshallFloyd.dist(g)[s];\n\t\t\tlong distReversed[][] =\
    \ WarshallFloyd.dist(g.numNode, g.directed, g.reverseEdges());\n\t\t\tlong distG1[]\
    \ = distReversed[g1];\n\t\t\tlong distG2[] = distReversed[g2];\n\t\t\tlong min\
    \ = INF;\n\t\t\tfor(int i = 0; i < n; i ++) {\n\t\t\t\tif(isINF(distS[i]) || isINF(distG1[i])\
    \ || isINF(distG2[i])) continue;\n\t\t\t\tmin = min(min, distS[i] + distG1[i]\
    \ + distG2[i]);\n\t\t\t}\n\t\t\tprtln(min);\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/WarshallFloyd.java
  isVerificationFile: true
  path: library/WarshallFloyd_reversed_test.java
  requiredBy: []
  timestamp: '2022-10-04 23:36:08+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/WarshallFloyd_reversed_test.java
layout: document
redirect_from:
- /verify/library/WarshallFloyd_reversed_test.java
- /verify/library/WarshallFloyd_reversed_test.java.html
title: library/WarshallFloyd_reversed_test.java
---