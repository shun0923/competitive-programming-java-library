---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/WeightedLca.java
    title: library/WeightedLca.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://yukicoder.me/problems/no/898
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://yukicoder.me/problems/no/898\n\n\
    package library;\n\nimport library.Solver;\nimport library.AbstractGraph;\nimport\
    \ library.WeightedLca;\n\npublic class WeightedLca_test extends Solver {\n\tpublic\
    \ static void main(final String[] args) { main(args, new WeightedLca_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tArrayWeightedGraph g =\
    \ new ArrayWeightedGraph(n, false);\n\t\tfor(int i = 0; i < n - 1; i ++) g.add(ni(),\
    \ ni(), nl());\n\t\tWeightedLca lca = new WeightedLca(g, 0, 0, (cost1, cost2)\
    \ -> cost1 + cost2);\n\t\tint q = ni();\n\t\tfor(int query = 0; query < q; query\
    \ ++) {\n\t\t\tint x[] = ni(3);\n\t\t\tlong ans = 0;\n\t\t\tfor(int i = 0; i <\
    \ 3; i ++) ans += lca.cal(x[i == 0 ? 2 : i - 1], x[i]).cost;\n\t\t\tprtln(ans\
    \ / 2);\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/WeightedLca.java
  isVerificationFile: true
  path: library/WeightedLca_test.java
  requiredBy: []
  timestamp: '2022-10-04 23:36:08+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/WeightedLca_test.java
layout: document
redirect_from:
- /verify/library/WeightedLca_test.java
- /verify/library/WeightedLca_test.java.html
title: library/WeightedLca_test.java
---
