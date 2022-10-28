---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':heavy_check_mark:'
    path: library/Rerooting.java
    title: library/Rerooting.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_5_B
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 421, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 526, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_5_B\n\
    \npackage library;\n\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.Rerooting;\n\npublic class Rerooting_test extends Solver {\n\t\
    public static void main(final String[] args) { main(args, new Rerooting_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tArrayWeightedGraph g =\
    \ new ArrayWeightedGraph(n, false);\n\t\tfor(int i = 0; i < n - 1; i ++) g.add(ni(),\
    \ ni(), nl());\n\t\tRerooting rr = new Rerooting(n, g.nodes(), 0, 0,\n\t\t\t\t\
    (x1, x2) -> max(x1, x2),\n\t\t\t\t(e, x) -> e.cost + x,\n\t\t\t\t(v, x) -> x,\n\
    \t\t\t\t(v) -> 0);\n\t\tprtlns(rr.cal());\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/Rerooting.java
  isVerificationFile: true
  path: library/Rerooting_test.java
  requiredBy: []
  timestamp: '2022-10-05 10:53:05+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Rerooting_test.java
layout: document
redirect_from:
- /verify/library/Rerooting_test.java
- /verify/library/Rerooting_test.java.html
title: library/Rerooting_test.java
---