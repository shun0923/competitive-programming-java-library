---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':heavy_check_mark:'
    path: library/BellmanFord.java
    title: library/BellmanFord.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_1_B
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_1_B\n\
    \npackage library;\n\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.BellmanFord;\n\npublic class BellmanFord_test extends Solver {\n\
    \tpublic static void main(final String[] args) { main(args, new BellmanFord_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tint m = ni();\n\t\tint\
    \ r = ni();\n\t\tArrayWeightedGraph g = new ArrayWeightedGraph(n, true);\n\t\t\
    for(int i = 0; i < m; i ++) g.add(ni(), ni(), nl());\n\t\tlong dist[] = BellmanFord.dist(g,\
    \ r);\n\t\tif(isINF(min(dist))) prtln(\"NEGATIVE CYCLE\");\n\t\telse for(long\
    \ ele : dist) prtln(isINF(ele) ? \"INF\" : ele);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/BellmanFord.java
  isVerificationFile: true
  path: library/BellmanFord_test.java
  requiredBy: []
  timestamp: '2022-10-03 17:15:22+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/BellmanFord_test.java
layout: document
redirect_from:
- /verify/library/BellmanFord_test.java
- /verify/library/BellmanFord_test.java.html
title: library/BellmanFord_test.java
---
