---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':x:'
    path: library/TopologicalSort.java
    title: library/TopologicalSort.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_4_B
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_4_B\n\
    \npackage library;\n\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.TopologicalSort;\n\npublic class TopologicalSort_test extends Solver\
    \ {\n\tpublic static void main(final String[] args) { main(args, new TopologicalSort_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tint m = ni();\n\t\tArrayUnweightedGraph\
    \ g = new ArrayUnweightedGraph(n, true);\n\t\tfor(int i = 0; i < m; i ++) g.add(n\
    \ - ni() - 1, n - ni() - 1);\n\t\tint sorted[] = TopologicalSort.sort(g);\n\t\t\
    for(int i = 0; i < n; i ++) sorted[i] = n - sorted[i] - 1;\n\t\tprtlns(sorted);\n\
    \t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/TopologicalSort.java
  isVerificationFile: true
  path: library/TopologicalSort_test.java
  requiredBy: []
  timestamp: '2022-10-05 12:54:35+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/TopologicalSort_test.java
layout: document
redirect_from:
- /verify/library/TopologicalSort_test.java
- /verify/library/TopologicalSort_test.java.html
title: library/TopologicalSort_test.java
---
