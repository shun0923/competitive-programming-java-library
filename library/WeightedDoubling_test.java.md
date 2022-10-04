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
    path: library/WeightedDoubling.java
    title: library/WeightedDoubling.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://yukicoder.me/problems/no/1097
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://yukicoder.me/problems/no/1097\n\n\
    package library;\n\nimport library.Solver;\nimport library.AbstractGraph;\nimport\
    \ library.WeightedDoubling;\n\npublic class WeightedDoubling_test extends Solver\
    \ {\n\tpublic static void main(final String[] args) { main(args, new WeightedDoubling_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tArrayWeightedNode edges\
    \ = new ArrayWeightedNode(-1);\n\t\tfor(int i = 0; i < n; i ++) {\n\t\t\tint target\
    \ = i + ni();\n\t\t\tedges.add(i, target % n, target / n);\n\t\t}\n\t\tWeightedDoubling\
    \ db = new WeightedDoubling(n, (long)1e12, 0, (cost1, cost2) -> cost1 + cost2,\
    \ edges);\n\t\tint q = ni();\n\t\tfor(int i = 0; i < q; i ++) {\n\t\t\tWeightedEdge\
    \ e = db.cal(0, nl());\n\t\t\tprtln(e.target + e.cost * n);\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/WeightedDoubling.java
  isVerificationFile: true
  path: library/WeightedDoubling_test.java
  requiredBy: []
  timestamp: '2022-10-04 23:14:38+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/WeightedDoubling_test.java
layout: document
redirect_from:
- /verify/library/WeightedDoubling_test.java
- /verify/library/WeightedDoubling_test.java.html
title: library/WeightedDoubling_test.java
---
