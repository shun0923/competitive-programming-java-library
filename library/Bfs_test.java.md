---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':x:'
    path: library/Bfs.java
    title: library/Bfs.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_11_C
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
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_11_C\n\
    \npackage library;\n\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.Bfs;\n\npublic class Bfs_test extends Solver {\n\tpublic static\
    \ void main(final String[] args) { main(args, new Bfs_test()); }\n\n\tpublic void\
    \ solve() {\n\t\tint n = ni();\n\t\tUnweightedListGraph g = new UnweightedListGraph(n,\
    \ true);\n\t\tfor(int i = 0; i < n; i ++) {\n\t\t\tint source = ni() - 1;\n\t\t\
    \tint k = ni();\n\t\t\tfor(int j = 0; j < k; j ++) g.add(source, ni() - 1);\n\t\
    \t}\n\t\tint dist[] = Bfs.dist(g, 0);\n\t\tfor(int i = 0; i < n; i ++) prtln(i\
    \ + 1, dist[i]);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/Bfs.java
  isVerificationFile: true
  path: library/Bfs_test.java
  requiredBy: []
  timestamp: '2023-03-24 00:38:44+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/Bfs_test.java
layout: document
redirect_from:
- /verify/library/Bfs_test.java
- /verify/library/Bfs_test.java.html
title: library/Bfs_test.java
---
