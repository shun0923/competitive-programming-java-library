---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':x:'
    path: library/BellmanFord.java
    title: library/BellmanFord.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=2005
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n          \
    \         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 466, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 571, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=2005\n\
    \npackage library;\n\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.BellmanFord;\n\npublic class BellmanFord_reversed_test extends\
    \ Solver {\n\tpublic static void main(final String[] args) { main(args, new BellmanFord_reversed_test());\
    \ }\n\n\tpublic void solve() {\n\t\twhile(true) {\n\t\t\tint n = ni();\n\t\t\t\
    int m = ni();\n\t\t\tint s = ni() - 1;\n\t\t\tint g1 = ni() - 1;\n\t\t\tint g2\
    \ = ni() - 1;\n\t\t\tif(n == 0) return;\n\t\t\tvar g = new ArrayWeightedGraph(n,\
    \ true);\n\t\t\tfor(int i = 0; i < m; i ++) g.add(ni() - 1, ni() - 1, nl());\n\
    \t\t\tlong distS[] = BellmanFord.dist(g, s);\n\t\t\tlong distG1[] = BellmanFord.dist(g.numNode,\
    \ g.reverseEdges(), g1);\n\t\t\tlong distG2[] = BellmanFord.dist(g.numNode, g.reverseEdges(),\
    \ g2);\n\t\t\tlong min = INF;\n\t\t\tfor(int i = 0; i < n; i ++) {\n\t\t\t\tif(isINF(distS[i])\
    \ || isINF(distG1[i]) || isINF(distG2[i])) continue;\n\t\t\t\tmin = min(min, distS[i]\
    \ + distG1[i] + distG2[i]);\n\t\t\t}\n\t\t\tprtln(min);\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/BellmanFord.java
  isVerificationFile: true
  path: library/BellmanFord_reversed_test.java
  requiredBy: []
  timestamp: '2023-03-23 23:34:20+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/BellmanFord_reversed_test.java
layout: document
redirect_from:
- /verify/library/BellmanFord_reversed_test.java
- /verify/library/BellmanFord_reversed_test.java.html
title: library/BellmanFord_reversed_test.java
---
